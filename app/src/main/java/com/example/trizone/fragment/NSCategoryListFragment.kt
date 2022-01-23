package com.example.trizone.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trizone.R
import com.example.trizone.adapter.NSDataAdapter
import com.example.trizone.data.NSDataModel
import com.example.trizone.webservice.NSApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*Created by Maneesha on 8/01/2022*/
class NSCategoryListFragment : Fragment() {

    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<NSDataModel>()
    lateinit var itemRecyclerView: RecyclerView
    lateinit var adapter: NSDataAdapter

    /* companion object {
         private val ARG_PARAM = "productsList"
         fun newInstance(productsList: ArrayList<NSItemsViewModel>): NSCategoryListFragment {
             val fragment = NSCategoryListFragment()
             val args = Bundle()
             args.putParcelableArrayList("productsList", productsList as ArrayList<out Parcelable?>?)

             // fragment.arguments!!.putParcelable("productsList", BaseParcelable(productsList))
             fragment.arguments = args

             return fragment
         }
     }
 */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_tab, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemRecyclerView = view.findViewById(R.id.recyclerView)
        itemRecyclerView.adapter = context?.let { NSDataAdapter(dataList, it.applicationContext) }
        itemRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        progerssProgressDialog = ProgressDialog(context)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()

        /*  var itemsList = ArrayList<NSItemsViewModel>()
          for (i in 1..20) {
              itemsList.add(NSItemsViewModel(R.drawable.item, "Item " + i, i))
          }
          adapter = NSItemRecyclerAdapter(itemsList)
          itemRecyclerView.adapter = adapter*/
    }

    private fun getData() {
        val call: Call<List<NSDataModel>> = NSApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<NSDataModel>> {

            override fun onResponse(
                call: Call<List<NSDataModel>>?,
                response: Response<List<NSDataModel>>?
            ) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                itemRecyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<NSDataModel>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()
            }

        })
    }

}