package `in`.xparticle.test_app.util

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class AppUtils {

    companion object{

        fun alertDialog(
            title:String,
            message:String,
            context:Context
        ){
            val dialogBox =AlertDialog.Builder(context)
            dialogBox.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(
                    "Ok"
                ) { dialog, id ->
                    dialog.cancel()
                }

            val alert = dialogBox.create()
            alert.setTitle(title)
            alert.show()
        }

        fun posNegAlertDialog(
            title:String,
            message:String,
            context:Context,
            buttonInteface:ButtonClickInterface
        ){
            val dialogBox =AlertDialog.Builder(context)
            dialogBox.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("cancel",DialogInterface.OnClickListener{
                        dialog, which ->  buttonInteface.negativeButtonClicked()
                })

                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> buttonInteface.positiveButtonClicked()
                })

            val alert = dialogBox.create()
            alert.setTitle(title)
            alert.show()
        }
    }


}

interface ButtonClickInterface{
    fun positiveButtonClicked()
    fun negativeButtonClicked()
}