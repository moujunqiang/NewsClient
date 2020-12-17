package com.example.newsclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsclient.R;
import com.example.newsclient.bean.ImageTextView;

import java.util.List;

public class ImageTextAdapter extends ArrayAdapter<ImageTextView> {    // 适配器，泛型表示想要适配的数据类型

    private int resourceId;

    public ImageTextAdapter(Context context, int textViewResourceId,
                            List<ImageTextView> objects) {                         // 第一个参数是上下文环境，第二个参数是每一项的子布局，第三个参数是数据
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;                   //获取子布局
    }

    @Override         //getView方法在每个子项被滚动到屏幕内的时候都会被调用，每次都将布局重新加载一边
    public View getView(int position, View convertView, ViewGroup parent) {//第一个参数表示位置，第二个参数表示缓存布局，第三个表示绑定的view对象
        View view;
        ViewHolder viewHolder;                  //实例ViewHolder，当程序第一次运行，保存获取到的控件，提高效率
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(//convertView为空代表布局没有被加载过，即getView方法没有被调用过，需要创建
                    resourceId, null);          // 得到子布局，非固定的，和子布局id有关
            viewHolder.ivImage = (ImageView) view.findViewById(R.id.ivImage);//获取控件,只需要调用一遍，调用过后保存在ViewHolder中
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);   //获取控件
            view.setTag(viewHolder);
        } else {
            view = convertView;           //convertView不为空代表布局被加载过，只需要将convertView的值取出即可
            viewHolder = (ViewHolder) view.getTag();
        }

        ImageTextView imageTextView = getItem(position);//实例指定位置的水果

        viewHolder.ivImage.setImageResource(imageTextView.getImageId());//获得指定位置水果的id
        viewHolder.tvName.setText(imageTextView.getContent());        //获得指定位置水果的名字
        return view;

    }
}

class ViewHolder {      //当布局加载过后，保存获取到的控件信息。
    ImageView ivImage;
    TextView tvName;
}