package mustafaozhan.github.com.mycurrencies.main.fragment.adapter

import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_currency.view.*
import mustafaozhan.github.com.mycurrencies.R
import mustafaozhan.github.com.mycurrencies.base.adapter.BaseRecyclerViewAdapter
import mustafaozhan.github.com.mycurrencies.base.adapter.BaseViewHolder
import mustafaozhan.github.com.mycurrencies.extensions.setBackgroundByName
import mustafaozhan.github.com.mycurrencies.room.model.Currency

/**
 * Created by Mustafa Ozhan on 2018-07-16.
 */
class CurrencyAdapter : BaseRecyclerViewAdapter<Currency>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Currency> =
            RatesViewHolder(getViewHolderView(parent, R.layout.item_currency))

    class RatesViewHolder(itemView: View) : BaseViewHolder<Currency>(itemView) {
        override fun bind(item: Currency) {
            itemView.txtType.text = item.name
            itemView.txtAmount.text = (Math.floor(item.rate * 100) / 100).toString()
            itemView.imgRow.setBackgroundByName(item.name)
        }
    }
}