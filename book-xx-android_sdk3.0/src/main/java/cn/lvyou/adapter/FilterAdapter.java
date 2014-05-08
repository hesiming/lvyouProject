package cn.lvyou.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.lvyou.activity.R;
import cn.lvyou.domainbean_model.categorys.categorybeans.ICategoryItem;

public class FilterAdapter extends BaseAdapter {
  private Context context;
  private LayoutInflater inflater;
  private List<ICategoryItem> categoryItems;
  private int selectedItemId;

  public FilterAdapter(Context context, List<ICategoryItem> categoryItems) {
    this.context = context;
    this.categoryItems = categoryItems;
    inflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {
    return categoryItems.size();
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder = null;
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.listview_item_selected_simple_text, null);
      holder = new ViewHolder();
      holder.textView = (TextView) convertView.findViewById(R.id.textview1);
      holder.imageView = (ImageView) convertView.findViewById(R.id.mIvCheck);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    holder.textView.setText(categoryItems.get(position).getDescription());

    if (position == 0) {
      convertView.setBackgroundColor(Color.parseColor("#e5e5e5"));
      holder.imageView.setVisibility(View.VISIBLE);
    } else {
      convertView.setBackgroundResource(R.drawable.bg_item_pop_selector);
      holder.imageView.setVisibility(View.INVISIBLE);
    }
    return convertView;
  }

  public static class ViewHolder {
    public TextView textView;
    public ImageView imageView;
  }

  public void setSelectedPosition(int selectedItemId) {
    this.selectedItemId = selectedItemId;
  }
}
