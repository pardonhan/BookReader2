package com.book.book.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.book.book.Config;
import com.book.book.db.BookMarks;
import com.book.book.util.PageFactory;

import java.text.DecimalFormat;
import java.util.List;


public class MarkAdapter extends BaseAdapter {
    private Context mContext;
    private List<BookMarks> list;
    private Config config;
    private PageFactory pageFactory;

    public MarkAdapter(Context context, List<BookMarks> list) {
        mContext = context;
        this.list = list;
        pageFactory = PageFactory.getInstance();
        config = config.getInstance();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(com.book.book.R.layout.item_bookmark, null);
            viewHolder.text_mark = (TextView) convertView.findViewById(com.book.book.R.id.text_mark);
            viewHolder.progress1 = (TextView) convertView.findViewById(com.book.book.R.id.progress1);
            viewHolder.mark_time = (TextView) convertView.findViewById(com.book.book.R.id.mark_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text_mark.setText(list.get(position).getText());
        long begin = list.get(position).getBegin();
        float fPercent = (float) (begin * 1.0 / pageFactory.getBookLen());
        DecimalFormat df = new DecimalFormat("#0.0");
        String strPercent = df.format(fPercent * 100) + "%";
        viewHolder.progress1.setText(strPercent);
        viewHolder.mark_time.setText(list.get(position).getTime().substring(0, 16));
        return convertView;
    }

    class ViewHolder {

        TextView text_mark, progress1, mark_time;
    }

}
