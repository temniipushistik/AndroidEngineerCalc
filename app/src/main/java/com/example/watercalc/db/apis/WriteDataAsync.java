package com.example.watercalc.db.apis;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.watercalc.db.App;
import com.example.watercalc.db.AppDatabase;
import com.example.watercalc.db.Site;
import com.example.watercalc.db.SiteDao;

public class WriteDataAsync extends AsyncTask<Site, Void, Void> {

    Context mContext;

    public WriteDataAsync(Context activity) {
        mContext = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Site... params) {
        App app = App.getInstance();
        for (Site site : params) {
            AppDatabase db = app.getDatabase(mContext.getApplicationContext());
            SiteDao siteDao = db.siteDao();
            siteDao.insert(site);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
                                Toast.makeText(mContext.getApplicationContext(),
                                "Data has been sent",
                                Toast.LENGTH_SHORT).show();
        super.onPostExecute(result);

    }

}
