package br.com.liveo.mvp.util.view.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.DatePicker;

import java.util.Calendar;

import br.com.liveo.mvp.base.BaseDialog;
import br.com.liveo.mvp.util.date.DateUtil;

public class DatePickerFragment extends BaseDialog implements DatePickerDialog.OnDateSetListener {

    private static OnDateConfirmListener sListener;
    private static boolean disableFutureDate;

    private static Calendar sCalendar;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year = getCalendar().get(Calendar.YEAR);
        int month = getCalendar().get(Calendar.MONTH);
        int day = getCalendar().get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this,
                year, month, day);

        if (disableFutureDate) {
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        }

        return datePickerDialog;
    }

    public void disableFutureDate() {
        if (this.getDialog() != null) {
            ((DatePickerDialog) this.getDialog()).getDatePicker().setMaxDate(System.currentTimeMillis());
        }
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (sListener != null) {
            sCalendar.set(year, month, day);
            sListener.onDateConfirm(DateUtil.formatDateToString(sCalendar.getTime()));
        }
    }

    public void setOnDateConfirmListener(OnDateConfirmListener listener) {
        sListener = listener;
    }

    public interface OnDateConfirmListener {

        void onDateConfirm(String dateFormatted);
    }

    public static Calendar getCalendar() {
        if (sCalendar == null) {
            sCalendar = Calendar.getInstance();
        }

        return sCalendar;
    }

    public static class Builder {
        private String dateAsString;

        public Builder setDate(String date) {
            dateAsString = date;
            return this;
        }

        public Builder setOnDateConfirmListener(OnDateConfirmListener onDateConfirmListener) {
            sListener = onDateConfirmListener;
            return this;
        }

        public Builder disableFutureDate() {
            disableFutureDate = true;
            return this;
        }

        public DatePickerFragment create() {
            DatePickerFragment fragment = new DatePickerFragment();

            if (!TextUtils.isEmpty(dateAsString)) {
                getCalendar().setTime(DateUtil.getDate(dateAsString, DateUtil.DATE_FORMAT_LOCAL));
            }

            return fragment;
        }
    }
}