package de.vogella.android.myapplication2.app;

/**
 * Created by shotaokutsu on 4/25/14.
 */
public interface AsyncCallback {
    void onPreExecute();
    void onPostExecute(String result);
    void onProgressUpdate(int progress);
    void onCancelled();
}
