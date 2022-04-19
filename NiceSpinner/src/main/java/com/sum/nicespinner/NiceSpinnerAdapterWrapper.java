package com.sum.nicespinner;

import android.content.Context;
import android.widget.ListAdapter;

/**
 * @author liujiang
 * created at: 2022/4/19 16:03
 * Desc:
 */
public class NiceSpinnerAdapterWrapper extends NiceSpinnerBaseAdapter {

    private final ListAdapter baseAdapter;

    NiceSpinnerAdapterWrapper(
            Context context,
            ListAdapter toWrap,
            int textColor,
            int backgroundSelector,
            SpinnerTextFormatter spinnerTextFormatter,
            PopUpTextAlignment horizontalAlignment
    ) {
        super(context, textColor, backgroundSelector, spinnerTextFormatter, horizontalAlignment);
        baseAdapter = toWrap;
    }

    @Override public int getCount() {
        return baseAdapter.getCount() - 1;
    }

    @Override public Object getItem(int position) {
        return baseAdapter.getItem(position >= selectedIndex ? position + 1 : position);
    }

    @Override public Object getItemInDataset(int position) {
        return baseAdapter.getItem(position);
    }
}