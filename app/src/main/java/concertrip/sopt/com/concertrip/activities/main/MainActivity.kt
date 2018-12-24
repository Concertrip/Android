package concertrip.sopt.com.concertrip.activities.main

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import concertrip.sopt.com.concertrip.activities.main.interfaces.OnFragmentInteractionListener
import concertrip.sopt.com.concertrip.utillity.Constants

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates
import concertrip.sopt.com.concertrip.R
import concertrip.sopt.com.concertrip.activities.main.adapter.MainFragmentAdapter
import concertrip.sopt.com.concertrip.utillity.Constants.Companion.FRAGMENT_LIKED
import concertrip.sopt.com.concertrip.utillity.Constants.Companion.FRAGMENT_MY_PAGE


class MainActivity : AppCompatActivity() , OnFragmentInteractionListener {
    override fun changeFragment(what: Int, bundle: Bundle?) {
        fragmentAdapter.setFragment(what,bundle)
    }

    override fun changeFragment(what: Int) {
        changeFragment(what,null)

    }

    override fun onFragmentInteraction(uri: Uri) {

        //Fragment에서 발생한 이벤트를 MainActivity에서 처리해야 할 일이 있을때!

    }

    var fragmentAdapter : MainFragmentAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      setSupportActionBar(toolbar)

        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("캘린더"))
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("탐색"))
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("찜목록"))
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_tab).setText("마이페이지"))


        fragmentAdapter = MainFragmentAdapter(supportFragmentManager, main_tab)
        main_tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    Constants.TAB_CALENDAR->{
                        fragmentAdapter.setFragment(Constants.FRAGMENT_CALENDAR)
                    }
                    Constants.TAB_SEARCH->{
                        fragmentAdapter.setFragment(Constants.FRAGMENT_SEARCH)
                    }
                    Constants.TAB_LIKED->{
                        fragmentAdapter.setFragment(FRAGMENT_LIKED)
                    }
                    Constants.TAB_MY_PAGE->{
                        fragmentAdapter.setFragment(FRAGMENT_MY_PAGE)
                    }

                }
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

