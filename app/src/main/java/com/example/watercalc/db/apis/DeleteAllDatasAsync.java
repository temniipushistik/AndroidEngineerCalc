package com.example.watercalc.db.apis;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.watercalc.db.App;
import com.example.watercalc.db.AppDatabase;
import com.example.watercalc.db.Site;
import com.example.watercalc.db.SiteDao;

import java.util.List;

public class DeleteAllDatasAsync extends AsyncTask<Void, Void, List<Site>> {

    Context mContext;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Site> doInBackground(Void... params) {
        App app = App.getInstance();
        AppDatabase db = app.getDatabase(mContext.getApplicationContext());
        SiteDao siteDao = db.siteDao();
        siteDao.deleteAll();
        return null;
    }

    @Override
    protected void onPostExecute(List<Site> result)
    {
        Toast.makeText(mContext.getApplicationContext(),
                "Data has been sent",
                Toast.LENGTH_SHORT).show();
        super.onPostExecute(result);
    }
}


