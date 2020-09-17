
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.shiraz.walmart.R
import com.shiraz.walmart.domain.User
import kotlinx.android.synthetic.main.activity_registeruser.*
import kotlinx.android.synthetic.main.activity_registeruser.password
import kotlinx.android.synthetic.main.activity_registeruser.username

class RegisterUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeruser)
    }

    //When User clicks on Create New Account button in User registration page
    fun onClickRegister(view: View) {

        if(firstName.text.toString().equals("")){
            Toast.makeText(this, "First Name cannot be null.", Toast.LENGTH_LONG).show()
        }else if (lastName.text.toString().equals("")){
            Toast.makeText(this, "Last Name cannot be null.", Toast.LENGTH_LONG).show()
        }else if (username.text.toString().equals("")){
            Toast.makeText(this, "Email address cannot be null.", Toast.LENGTH_LONG).show()
        }else if (password.text.toString().equals("")){
            Toast.makeText(this, "Password cannot be null.", Toast.LENGTH_LONG).show()
        }

        //Get fields from the register page and convert to String
        val firstName = firstName.text.toString()
        val lastName = lastName.text.toString()
        val username = username.text.toString()
        val password = password.text.toString()

        //if none of the field is empty, create user and add that user to userList
        if (firstName.isNotEmpty() && lastName.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {

            val user: User = User(firstName, lastName, username, password)
            val userList: UserList = UserList()

            userList.addUser(user)

            //Display message "Account Created Successfully" message
            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG).show()

            //Go to Shopping Activity class
            var intent = Intent(this, ShoppingActivity::class.java)

            //From MainActivity.kt pass the username to ShoppingCategory activity
            //Here, "username" is the key to retrieve the username in 2nd activity, i.e. ShoppingActivity
            intent.putExtra("username", username)
            startActivity(intent) //starts the intent
        }


    }
}
