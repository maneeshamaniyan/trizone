package com.example.trizone.activity

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.trizone.R
import com.example.trizone.fragment.NSCategoryListFragment
import com.google.android.material.tabs.TabLayout
/*Created by Maneesha on 8/01/2022*/
class NSCategoryActivity : AppCompatActivity() {

    private lateinit var categoryViewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category)


        var categoryTab = findViewById<TabLayout>(R.id.categoryTabLayout)


        categoryViewPager = findViewById<ViewPager>(R.id.listViewpager)


        setUpViewPager(categoryViewPager)
        categoryTab.setupWithViewPager(categoryViewPager)

        /*  val itemsList = ArrayList<NSItemsViewModel>()

          for (i in 1..20) {
              itemsList.add(NSItemsViewModel(R.drawable.item, "Item " + i, i))
          }
          val categoryListFragment = NSCategoryListFragment()

          //   val categoryListFragment = NSCategoryListFragment.newInstance(itemsList)


          val fragmentManager: FragmentManager = supportFragmentManager
          val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
          fragmentTransaction.replace(R.id.categoryListFragment, categoryListFragment).commit()*/

    }


    private fun setUpViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(NSCategoryListFragment(), getString(R.string.electrical))
        adapter.addFragment(NSCategoryListFragment(), getString(R.string.plumbing))
        adapter.addFragment(NSCategoryListFragment(), getString(R.string.sanitary))
       // adapter.addFragment(NSCategoryListFragment(), getString(R.string.paints))

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }

    class ViewPagerAdapter : FragmentPagerAdapter {

        // objects of arraylist. One is of Fragment type and
        // another one is of String type.*/
        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1.get(position)
        }

        // returns which item is selected from arraylist of titles.
        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList1.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }

}