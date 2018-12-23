package concertrip.sopt.com.concertrip.model

class Concert {
    var idx: Int=0
    var title : String = ""
    var profileImg : String =""
    var backImg : String =""
    var location : String =""
    var station : String =""
    var genre : String =""
    var cast : String =""
    var date : String =""
    var price : String =""
    var youtubeUrl : String =""

    fun getTag() : String ="#$genre #$genre"

    companion object {
        fun getDummyArray() : ArrayList<Concert>{
            val list = ArrayList<Concert>()
            for(i in 0..10) {
                val c = Concert()
                c.title="힙합 페스티발"
                c.idx=i
                c.genre="#힙합"
                c.youtubeUrl=""
                c.backImg=""
                c.profileImg="https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201801%2F20180108113919887.jpg"
                c.cast="지코"
                c.date="2018-12-23"
                list.add(c)
            }
            return list

        }
    }
}