package teneocto.thiemjason.newsonline.ui.progressdialog;

import android.app.ProgressDialog;
import android.content.Context;

import teneocto.thiemjason.newsonline.R;

public class CustomProgressDialog {
    ProgressDialog progressDialog;
    public CustomProgressDialog(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        progressDialog.setContentView(R.layout.loading_spinner);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawableResource(
                R.color.transparent
        );
    }

    public void deleteProgressDialog(){
        progressDialog.dismiss();
    }
}
