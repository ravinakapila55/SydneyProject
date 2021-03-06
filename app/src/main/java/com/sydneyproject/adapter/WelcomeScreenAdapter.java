package com.sydneyproject.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.sydneyproject.R;
import com.sydneyproject.model.SliderModel;
import java.util.ArrayList;

public class WelcomeScreenAdapter extends PagerAdapter
{
    private LayoutInflater inflater;
    private Context context;
    ArrayList<SliderModel> list;

    Integer array[] =
    {
            R.drawable.welcome_1,
            R.drawable.welcome_2
    };

    public WelcomeScreenAdapter(Context context, ArrayList<SliderModel> list)
    {
        this.context = context;
        this.list=list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position)
    {
        View imageLayout = inflater.inflate(R.layout.custom_slide_layout, view, false);
        assert imageLayout != null;
        final ImageView slideimg = (ImageView) imageLayout.findViewById(R.id.slideimg);
        final TextView name = (TextView) imageLayout.findViewById(R.id.name);
        final TextView desc = (TextView) imageLayout.findViewById(R.id.desc);

       /* Picasso.get().load(Constant.SPLASHIMAGEURL + list.get(position).getImage())
                .placeholder(R.drawable.noimageplaceholder).
                into(slideimg);*/
        name.setText(list.get(position).getTitle());
        desc.setText(list.get(position).getDescription());

        for (int i = 0; i <array.length ; i++)
        {
            slideimg.setImageResource(array[position]);
        }


        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader)
    {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
