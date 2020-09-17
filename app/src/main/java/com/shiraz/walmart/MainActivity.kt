
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.shiraz.walmart.R
import com.shiraz.walmart.domain.User

class MainActivity : AppCompatActivity() {

    /*
       If the user click the Sign In button, validate the user in the ArrayList, if it match with your data,
       then  your  Main  Activity  need  to  open  the  another  intent  Shopping  Category  activity
        */

    //get UserList
    var userList:UserList = UserList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSignIn(view: View){

        //get UserView and PasswordView from Login Screen
        var usernameView = findViewById<EditText>(R.id.username)
        var passwordView = findViewById<EditText>(R.id.password)

        //Convert usernameView and passwordView to String
        var username:String = usernameView.text.toString()
        var password:String = passwordView.text.toString()

        //get User from userList
        var user: User?=userList.getUserByUsernameAndPassword(username,password)


        //check if user exists or not
        if (user == null)
            Toast.makeText(this,"No User found with that username and password!",Toast.LENGTH_LONG).show()
        else{
            //if user exists with that username and password
            Toast.makeText(this,"Logged In Successfully", Toast.LENGTH_LONG).show()  //display 'Logged In Successfully msg

            /*
            Intent is used to request another app component to perform an action. Intent facilitates users to communicate
            with app component through several ways such as starting an activity, starting a service, delivering a
            broadcast receiver, etc.
             */

            //creating intent, similar to -> Intent intent = new Intent(this, ShoppingActivity.class) in Java
            var intent = Intent(this, ShoppingActivity::class.java)

            //From MainActivity.kt pass the username to ShoppingCategory activity
            //Here, "username" is the key to retrieve the username in 2nd activity, i.e. ShoppingActivity
            intent.putExtra("username", username)
            startActivity(intent) //starts the intent
        }
    }

    fun onClickRegister(view: View) {
        var intent = Intent(this, RegisterUserActivity::class.java)
        startActivity(intent)
    }


}
