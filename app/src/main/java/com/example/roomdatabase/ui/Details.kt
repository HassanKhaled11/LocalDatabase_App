package com.example.roomdatabase.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.model.entity.User
import com.example.roomdatabase.model.local.LocalRepositoryImp
import com.example.roomdatabase.model.local.UserDatabase
import com.example.roomdatabase.ui.adapter.UserRecyclerView
import kotlinx.coroutines.*


class Details : Fragment() {

    lateinit var rv_showData: RecyclerView
    lateinit var edt_message: EditText
    lateinit var t_add: Button
    lateinit var del_btn:Button

    var userlist: List<User> = emptyList()

    val userRecyclerView: UserRecyclerView by lazy {
        UserRecyclerView()            //b2olo bra7tk wnta bt create object 34an mya5od4 ml mwmory badry 3l fady
    }

    lateinit var localRepositoryImp: LocalRepositoryImp

    lateinit var progbar: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_details, container, false)
        rv_showData = view.findViewById(R.id.recycledata)
        edt_message = view.findViewById(R.id.editText)
        t_add = view.findViewById(R.id.addbut)
        del_btn = view.findViewById(R.id.deletebtn)

        rv_showData.adapter = userRecyclerView

        var db = UserDatabase.getInstance(requireContext())
        localRepositoryImp = LocalRepositoryImp(db)



        progbar = view.findViewById(R.id.progressBar)


        getAllUsers()

        t_add.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
                localRepositoryImp.insertOrUpdateUser(
                    User(
                        0,
                        "Hassan Khaled",
                        edt_message.text.toString(),
                        R.drawable.avatar
                        )
                )
            }
            getAllUsers()
            edt_message.setText("")
        }


        return view
    }


    fun getAllUsers() {

        GlobalScope.launch(Dispatchers.IO)
        {

            var returnedUsers = async {                  // async 34an htrg3 7aga

                localRepositoryImp.getUsers()
            }

                withContext(Dispatchers.Main) {
                    progbar.visibility = View.VISIBLE
                    userlist = returnedUsers.await()
                    progbar.visibility = View.GONE
                    userRecyclerView.setList(userlist)

                }

            }

        }
}



