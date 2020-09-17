import com.shiraz.walmart.domain.User


class UserList{

    //create an ArrayList for the type of User, and store at least five users to validate login

    val userList: ArrayList<User> = ArrayList<User>()

    constructor(){
        userList.add(User("Samiksha","Gautam","samiksha@gmail.com", "samik"))
        userList.add(User("Ram","Shrestha", "ram@gmail.com","ram"))
        userList.add(User("Shire","Pandey", "shire@gmail.com","shire"))
        userList.add(User("Sita","Shah","sita@gmail.com","sita"))
        userList.add(User("Tony","Stark", "tony@stark.com","tony"))
    }

    //getUserByUsernameAndPassword - if user exist with that username & password, return user
    //else return null

    fun getUserByUsernameAndPassword(username:String, password: String): User? {
        for(user in userList){
            if (user.username.equals(username) && user.password.equals(password))
                return user
        }
        return null
    }

    //add new User to arraylist 'userList'
    fun addUser(user: User){
        userList.add(user)
    }

}