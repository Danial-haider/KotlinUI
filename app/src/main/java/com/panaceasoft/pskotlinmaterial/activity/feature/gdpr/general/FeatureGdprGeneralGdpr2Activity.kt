package com.panaceasoft.pskotlinmaterial.activity.feature.gdpr.general

import android.app.Dialog
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_gdpr_general_gdpr_2_activity.*

@Suppress("DEPRECATION")
class FeatureGdprGeneralGdpr2Activity : AppCompatActivity() {

    private val terms = "<strong>Cras eget nunc condimentum</strong>\n" +
            "<br><br>\n" +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.\n" +
            "<br><br>\n" +
            "Phasellus mi justo, dignissim molestie facilisis vel, consectetur et mi. Duis porta volutpat metus non tempus. Proin placerat, ante quis euismod iaculis, tellus lectus placerat quam, a maximus tellus elit ut lectus. Vivamus condimentum lectus id diam volutpat ornare. Nulla facilisi. Sed ac pulvinar mi. Nunc sit amet nibh risus. Sed dolor nisi, faucibus sed urna a, condimentum eleifend neque. Nulla et dignissim turpis. Quisque mattis vulputate neque sit amet maximus.\n" +
            "<br><br>\n" +
            "<strong>Vivamus condimentum lectus id diam volutpat ornare</strong>\n" +
            "<br><br>\n" +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.\n" +
            "<br><br>"

    private val privacy = "<strong>Lorem ipsum dolor sit amet</strong>\n" +
            "<br><br>\n" +
            "Integer tincidunt justo dictum nisi dapibus, non egestas justo bibendum. Nullam vel consectetur nulla. Donec id placerat augue, sed semper metus. Donec pharetra vestibulum massa a bibendum. Donec sit amet enim et nisi imperdiet eleifend a nec nibh. In hac habitasse platea dictumst. Duis eu aliquam dui. Suspendisse potenti. In ac iaculis nisi, ut cursus quam. Suspendisse justo ipsum, mattis sed ante eget, cursus sodales neque. Fusce tristique lobortis nisi. Vivamus nibh mi, eleifend non facilisis a, posuere eget tortor. In lobortis gravida finibus. Vestibulum quis molestie tortor, quis varius est. Nam aliquam pharetra molestie.\n" +
            "<br><br>\n" +
            "Phasellus mi justo, dignissim molestie facilisis vel, consectetur et mi. Duis porta volutpat metus non tempus. Proin placerat, ante quis euismod iaculis, tellus lectus placerat quam, a maximus tellus elit ut lectus. Vivamus condimentum lectus id diam volutpat ornare. Nulla facilisi. Sed ac pulvinar mi. Nunc sit amet nibh risus. Sed dolor nisi, faucibus sed urna a, condimentum eleifend neque. Nulla et dignissim turpis. Quisque mattis vulputate neque sit amet maximus.\n" +
            "<br><br>\n" +
            "<strong>Cras eget nunc condimentum</strong>\n" +
            "<br><br>\n" +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.\n" +
            "<br><br>"

    private val licenses = "\n" +
            "<strong>Suspendisse magna augue, interdum at nunc eget.</strong>\n" +
            "<br><br>\n" +
            "Phasellus et eros eu diam aliquam ultrices nec nec nisi. Aenean facilisis ligula quis tempus tempus. Duis ornare ante aliquet odio egestas pulvinar. Ut mollis lacinia diam et hendrerit. Aenean dolor dolor, tempor vitae viverra sit amet, rhoncus sit amet metus. Cras tempor dui quam, scelerisque cursus magna congue quis. Vestibulum lobortis est sed ex euismod fringilla. Proin a nunc non mi fermentum rhoncus. Morbi sed commodo justo. Ut luctus tincidunt tortor, id dictum libero vehicula a.\n" +
            "<br><br>\n" +
            "Phasellus mi justo, dignissim molestie facilisis vel, consectetur et mi. Duis porta volutpat metus non tempus. Proin placerat, ante quis euismod iaculis, tellus lectus placerat quam, a maximus tellus elit ut lectus. Vivamus condimentum lectus id diam volutpat ornare. Nulla facilisi. Sed ac pulvinar mi. Nunc sit amet nibh risus. Sed dolor nisi, faucibus sed urna a, condimentum eleifend neque. Nulla et dignissim turpis. Quisque mattis vulputate neque sit amet maximus.\n" +
            "<br><br>\n" +
            "<strong>Cras eget nunc condimentum</strong>\n" +
            "<br><br>\n" +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget nunc condimentum, volutpat diam in, molestie nisl.\n" +
            "<br><br>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_gdpr_general_gdpr_2_activity)

        initDataBindings()

        initActions()
    }


    private fun initDataBindings() {

        Utils.setImageToImageView(applicationContext, gdprBgImageVIew, R.drawable.star_bg)

    }


    private fun initActions() {
        backImageButton.setOnClickListener {  this.finish() }

        termsButton.setOnClickListener {  getCustomLayoutDialog(R.layout.feature_gdpr_general_gdpr_2_layout, "TERMS OF USE", terms) }

        privacyButton.setOnClickListener {  getCustomLayoutDialog(R.layout.feature_gdpr_general_gdpr_2_layout, "PRIVACY POLICY", privacy) }

        licensesButton.setOnClickListener {  getCustomLayoutDialog(R.layout.feature_gdpr_general_gdpr_2_layout, "LICENSES", licenses) }
    }


    private fun getCustomLayoutDialog(layoutId: Int, title: String, detail: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        val titleTextView = dialog.findViewById<TextView>(R.id.titleTextView)
        titleTextView.text = title

        val msgTextView = dialog.findViewById<TextView>(R.id.messageTextView)
        msgTextView.text = Html.fromHtml(detail)
        msgTextView.movementMethod = LinkMovementMethod.getInstance()

        val closeImageButton = dialog.findViewById<ImageButton>(R.id.closeImageButton)
        closeImageButton.setOnClickListener { dialog.cancel() }

        if (dialog.window != null) {
            dialog.window?.attributes = getLayoutParams(dialog)
        }
        dialog.show()
    }

    private fun getLayoutParams(dialog: Dialog): WindowManager.LayoutParams {
        val layoutParams = WindowManager.LayoutParams()
        if (dialog.window != null) {
            layoutParams.copyFrom(dialog.window?.attributes)
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        return layoutParams
    }


}
