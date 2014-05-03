package cn.lvyou.fragment;

import cn.retech.my_network_engine.IDomainBeanAsyncHttpResponseListener;
import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;

import cn.retech.my_network_engine.IDomainBeanAsyncHttpResponseListener;
import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;

import cn.retech.my_network_engine.SimpleNetworkEngineSingleton;

import cn.retech.domainbean_model.categorys.CategorysNetRequestBean;

import cn.retech.my_network_engine.INetRequestHandle;
import cn.retech.my_network_engine.NetRequestHandleNilObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.lvyou.activity.R;

/**
 * 主界面
 * 
 * @author hesiming
 * 
 */
public class HomeFragment extends Fragment {
  private INetRequestHandle netRequestHandleForCategroys = new NetRequestHandleNilObject();

  public HomeFragment() {
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    requestCategroys();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_home, container, false);

    return rootView;
  }

  @Override
  public void onStart() {
    super.onStart();
  }

  private void requestCategroys() {
    CategorysNetRequestBean categorysNetRequestBean = new CategorysNetRequestBean();
    netRequestHandleForCategroys =
        SimpleNetworkEngineSingleton.getInstance.requestDomainBean(categorysNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {
          @Override
          public void onFailure(MyNetRequestErrorBean error) {
            // TODO Auto-generated method stub
          }

          @Override
          public void onSuccess(Object respondDomainBean) {
            // TODO Auto-generated method stub
          }
        });
  }
}
