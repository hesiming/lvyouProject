package cn.retech.my_custom_network_engine.http_engine.async_http_client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

import com.loopj.android.http.FileAsyncHttpResponseHandler;

public class RandomAccessFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {

  private final long seekPos;

  public RandomAccessFileAsyncHttpResponseHandler(File file, long seekPos) {
    super(file);

    this.seekPos = seekPos;
  }

  private byte[] getMyResponseData(HttpEntity entity) throws IOException {
    if (entity != null) {
      RandomAccessFile randomAccessFile = new RandomAccessFile(getTargetFile(), "rwd");
      randomAccessFile.seek(seekPos);
      InputStream instream = entity.getContent();
      long contentLength = entity.getContentLength();
      if (instream != null) {
        try {
          byte[] tmp = new byte[BUFFER_SIZE];
          int l, count = 0;
          // do not send messages if request has been cancelled
          while ((l = instream.read(tmp)) != -1 && !Thread.currentThread().isInterrupted()) {
            count += l;
            randomAccessFile.write(tmp, 0, l);
            sendProgressMessage((int)(seekPos + count), (int) (contentLength + seekPos));
          }
        } finally {
          instream.close();
          randomAccessFile.close();
        }
      }
    }
    return null;
  }

  @Override
  public void sendResponseMessage(HttpResponse response) throws IOException {
    // do not process if request has been cancelled
    if (!Thread.currentThread().isInterrupted()) {
      StatusLine status = response.getStatusLine();
      byte[] responseBody;
      responseBody = getMyResponseData(response.getEntity());
      // additional cancellation check as getResponseData() can take non-zero time to process
      if (!Thread.currentThread().isInterrupted()) {
        if (status.getStatusCode() >= 300) {
          sendFailureMessage(status.getStatusCode(), response.getAllHeaders(), responseBody, new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()));
        } else {
          sendSuccessMessage(status.getStatusCode(), response.getAllHeaders(), responseBody);
        }
      }
    }
  }
}
