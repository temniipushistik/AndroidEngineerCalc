package com.example.watercalc.db.apis;

import android.content.Context;
import android.os.AsyncTask;

import com.example.watercalc.db.App;
import com.example.watercalc.db.AppDatabase;
import com.example.watercalc.db.Site;
import com.example.watercalc.db.SiteDao;

import java.util.List;

public class GetAllDatasAsync extends AsyncTask<Void, Void, List<Site>> {

    Context mContext;


    public GetAllDatasAsync(Context activity) {
        mContext = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Site> doInBackground(Void... params) {
        App app = App.getInstance();
        AppDatabase db = app.getDatabase(mContext.getApplicationContext());
        SiteDao siteDao = db.siteDao();
        siteDao.getAll();
        return siteDao.getAll();
    }

    @Override
    protected void onPostExecute(List<Site> result) {
        super.onPostExecute(result);
    }
}

