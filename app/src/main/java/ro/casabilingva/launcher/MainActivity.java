package ro.casabilingva.launcher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/** Abre Casa Bilingvă en Chrome (con la sesión de Claude) y se cierra. */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.APP_URL));
        i.addCategory(Intent.CATEGORY_BROWSABLE);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setPackage("com.android.chrome");
        try {
            startActivity(i);
        } catch (Exception noChrome) {
            i.setPackage(null); // cualquier navegador
            try { startActivity(i); } catch (Exception ignored) { }
        }
        finish();
    }
}
