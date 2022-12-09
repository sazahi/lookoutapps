//package id.kotlin.recyclerview
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//
//
//class RecycleViewAdapter(mainActivity: MainActivity, cardview: Int, Items: ArrayList<Model>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
//
//    private val itemTitles = arrayOf("LookOut Admin", "Pemburu Waktu","Dollar Hunter","Street Life","workhard","Aldy Ganz Pars","MusikQ","Mie Sukses","Darwin Nunez","Farhan Aldyxx Razzan","Aldixxx","Luna","Juraimi")
//
//    private val itemDetails = arrayOf(
//        "Selamat Datang! Buat user - user anonim yang baru bergabung di LookOut!",
//        "Tambak langon arah greges banjir, macet 2 arah, banyak kendaraan roda 2 mogok. tabe pap bede titik macet pasca hujan biar yg lain tau. ini sender terjebak macet di kanal tembusan toddopuli 10 perbatasan gowa, jammeki lewat sini dlu guys.",
//        "Kayaknya Jakarta Timur itu emang sengaja dicontain deh biar ngga \"mencemari\" Jakarta Selatan. Sepanjang itu border antara Jaksel dan Jaktim cuma ada 4 akses yang bisa melewati natural barrier Kali Ciliwung (Kp. Melayu, Cawang, Kalibata, & Pasar Rebo) dan itu semuanya macet banget",
//        "Jalan Tambak Langon banjir. Anas via e100ss melaporkan, banyak motor mengalami mogok. Hindari lajur ini, Kawan",
//        "Keseul banget kalo cawang UKI dah mulai macet kek begini. Ngapasi mulai lg kmrn dah lancar2 aja lu bikin gue telat mulu deh",
//        "Asli! Dah gitu sibuk banget revit semua haltenya pdhl mending buat nambah armada , pusing bgt liat tata kelola jakarta skrng , bus dr uki sebelah kiri aja macet eh abis dari itu move ke kanan buat halte bnn , belom di halte depan shell kemenhuham , depannya lagi cawang! *** Lah",
//        "kalibata macet pol ya Allah\uD83D\uDE2D",
//        "musim ujannya jkt ini bikin gw makin mager pindah kos sama bawa motor. mau cari yg di kalibata, macet di jln layang. di kalimalang, macet di uki. disini pun kl bawa motor malah nyusahin mending jalan kaki aja pake payung.",
//        "Menggusur SD krn pemkot ga py aset lain di Margonda & ga py dana utk membeli tanah? Itu omong kosong. Biaya melebarkan trotoar yg ga ada guna, malah bikin macet itu berapa? Pemanfaatan dana yg sia2 & ga dibutuhkan masyarakat",
//        "Duh, istriku pas mau ke UI bilang depan Gunadarma macet. Anak2 mahasiswi mau pada demo.\n" +
//                "Usahakan mahasiswa tetap jaga kesehatan & menjauhi jarak (phisical distance) dg orang2 tua selama musim demo. Selamat berdemo. Tegakkan kedaulatan bangsa.",
//        "Rektor UI kejebak macet, kampusnya yg menghampiri pak rektor \uD83E\uDD74\uD83E\uDD2A",
//    "If you visit a website, they don't know who you are or your true location. If you sign in to that website, they still don't know your location but they know who you are ( Bjorka )\n",
//        "Memalukan dan pukulan terbesar untuk Enrique yang hanya mengenal sepak bola Spanyol. Thiago, De Gea punya kemampuan yang menjanjikan untuk malam ini. Tapi karena anak emas di Catalunya, sepak bola adalah mimpi buruk. Hakimi, Ziyech, Bono sudah mewakili dunia untuk Luis Enrique\uD83C\uDDEA\uD83C\uDDF8"
//    )
//
////  private val itemImages = intArrayOf(
// //     R.drawable.pro,
////        R.drawable.map,
////        R.drawable.avatar,
////        R.drawable.traffic
//  // )
//
//    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
//
////        var image : ImageView
//        var textTitle : TextView
//        var textDes : TextView
//
//        init {
////            image = itemView.findViewById(R.id.item_image)
//            textTitle = itemView.findViewById(R.id.txt_title)
//            textDes = itemView.findViewById(R.id.txt_description)
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = LayoutInflater.from(parent.context)
//            .inflate(R.layout.cardview,parent, false)
//        return ViewHolder(v)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textTitle.text = itemTitles[position]
//        holder.textDes.text = itemDetails[position]
////        holder.image.setImageResource(itemImages[position])
//
//        holder.itemView.setOnClickListener{v: View ->
//
//
//            Toast.makeText(v.context, "Clicked on", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return itemTitles.size
//    }
//
//}