package br.com.disapps.homepet.ui.hotel

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.disapps.homepet.R
import br.com.disapps.homepet.data.model.Hotel
import br.com.disapps.homepet.ui.common.AppActivity
import br.com.disapps.homepet.ui.hotel.hotelFragment.HotelFragment
import br.com.disapps.homepet.ui.hotels.adapter.ImageViewPagerAdapter
import br.com.disapps.homepet.ui.imageViewer.ImageViewerActivity
import br.com.disapps.homepet.util.extensions.startActivity
import kotlinx.android.synthetic.main.activity_hotel.*
import org.koin.android.ext.android.inject


/**
 * Created by diefferson.santos on 31/08/17.
 */

class HotelActivity : AppActivity(), AppBarLayout.OnOffsetChangedListener, IHotelView {

    private val presenter by inject<HotelPresenter>()
    private var hotel: Hotel?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        presenter.attachView(this)

        setToolbar(toolbar)
        setContainer(container!!)

        val hotelCode = intent.extras!!.getInt("hotelCode")

        presenter.loadHotel(hotelCode)

        replaceFragment(HotelFragment.newInstance(hotelCode))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        when (id) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }

            R.id.full_screem->{
                val extras  = Bundle()
                extras.putSerializable("hotel", hotel)
                startActivity(ImageViewerActivity::class.java, extras)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun fillHeaderHotel(h: Hotel) {

        hotel = h

        setTitle(hotel!!.name)

        if(hotel!!.images != null && !hotel!!.images!!.isEmpty()){
            image_slide!!.adapter = ImageViewPagerAdapter(this, hotel!!.images!!)
            pageIndicatorView!!.setViewPager(image_slide)
            pageIndicatorView!!.visibility = View.VISIBLE
            image_slide.visibility = View.VISIBLE

            collapsing.setOnClickListener {
                val extras  = Bundle()
                extras.putSerializable("hotel", hotel)
                startActivity(ImageViewerActivity::class.java, extras)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.hotel_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {

    }

}