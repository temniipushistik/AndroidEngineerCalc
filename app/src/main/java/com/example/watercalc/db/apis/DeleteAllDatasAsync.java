package com.example.watercalc.db.apis;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.watercalc.db.App;
import com.example.watercalc.db.AppDatabase;
import com.example.watercalc.db.Site;
import com.example.watercalc.db.SiteDao;

import java.util.List;

public class DeleteAllDatasAsync extends AsyncTask<Void, Void, Void> {

    //Context это активити ( мэйн активити) на которой происходят действия асинхтаска
    Context mContext;

    public DeleteAllDatasAsync(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {//Void тип данных, может вернуть функцию( не значение!!!)
        App app = App.getInstance();
        AppDatabase db = app.getDatabase(mContext.getApplicationContext());
        SiteDao siteDao = db.siteDao();
        siteDao.deleteAll();
        return null;

    }


    @Override
    protected void onPostExecute(Void result) {
        Toast.makeText(mContext.getApplicationContext(),
                "Data has been deleted",
                Toast.LENGTH_SHORT).show();
        super.onPostExecute(result);
    }
}


