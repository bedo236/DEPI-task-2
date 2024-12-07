package com.example.task2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task2.BwstPracyiseAdaptor

import com.example.task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private val bwstPracyiseAdaptor by lazy { BwstPracyiseAdaptor() }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
//        bwstPracyiseAdaptor.onItemClick = this
//        enableEdgeToEdge()


//        val customAdaptor = BwstPracyiseAdaptor(getItems())
//        binding.recyclerView.adapter = customAdaptor
//        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)


//        bwstPracyiseAdaptor.updateList(getMoreItems())
//        binding.recyclerView.adapter = bwstPracyiseAdaptor
//        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)


        bwstPracyiseAdaptor.updateList(getMovies())
        val animationController = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation)
        binding.recyclerView.layoutAnimation = animationController
        binding.recyclerView.scheduleLayoutAnimation()





        binding.recyclerView.adapter = bwstPracyiseAdaptor
        binding.recyclerView.layoutManager = LinearLayoutManager(this)





        val username = intent.getStringExtra(Constants.USERNAME).toString()
        val username_text = findViewById<TextView>(R.id.welcomeTextView)
        username_text.text = "Welcome $username"
    }

//    override fun onItemClick(item: String, position: Int) {
////        bwstPracyiseAdaptor.updateList(getItems())
////        Toast.makeText(this, "item clicked: $item of position $position", Toast.LENGTH_SHORT).show()
//    }



//    override fun onItemClick(item: Movie, position: Int) {
//        Toast.makeText(this, "Movie clicked: ${item.title}", Toast.LENGTH_SHORT).show()
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.more -> {
                val animationController = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation)
                binding.recyclerView.layoutAnimation = animationController
                bwstPracyiseAdaptor.updateList(getMoreMovies())
                binding.recyclerView.scheduleLayoutAnimation()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }



}


private fun getMovies(): List<Movie> {
    return listOf(
        Movie("Spider-Man: Homecoming", 7.4, "Peter Parker tries to stop Adrian 'The Vulture' Toomes from selling weapons made with advanced Chitauri technology while trying to balance his life as an ordinary high school student.", "2017-01-21", R.drawable.movie1),
        Movie("Doctor Strange in the Multiverse of Madness", 6.9, "Doctor Strange teams up with a mysterious teenage girl who can travel across multiverses, to battle other-universe versions of himself which threaten to wipe out the multiverse. They seek help from the Scarlet Witch, Wong and others.", "2022-02-10", R.drawable.movie2),
        Movie("Iron Man 2", 6.9, "With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful mad man with ties to his father's legacy.", "2010-03-15", R.drawable.movie3),
        Movie("Avengers: Infinity War", 8.4, "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.", "2018-04-20", R.drawable.movie4),
        Movie("Avengers: Endgame", 8.4, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", "2019-05-25", R.drawable.movie5),
        Movie("The Avengers", 8.0, "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", "2012-06-30", R.drawable.movie6),
        Movie("The Dark Knight", 9.0, "When a menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman, James Gordon and Harvey Dent must work together to put an end to the madness.", "2008-07-10", R.drawable.movie7),
        Movie("Joker", 8.4, "Arthur Fleck, a party clown and a failed stand-up comedian, leads an impoverished life with his ailing mother. However, when society shuns him and brands him as a freak, he decides to embrace the life of chaos in Gotham City.", "2019-08-01", R.drawable.movie8),
        Movie("John Wick", 7.4, "John Wick is a former hitman grieving the loss of his true love. When his home is broken into, robbed, and his dog killed, he is forced to return to action to exact revenge.", "2014-09-11", R.drawable.movie9),
        Movie("Interstellar", 8.7, "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", "2014-10-05", R.drawable.movie10),
    )
}

private fun getMoreMovies(): List<Movie>{
    return listOf(
        Movie("Spider-Man: Homecoming", 7.4, "Peter Parker tries to stop Adrian 'The Vulture' Toomes from selling weapons made with advanced Chitauri technology while trying to balance his life as an ordinary high school student.", "2017-01-21", R.drawable.movie1),
        Movie("Doctor Strange in the Multiverse of Madness", 6.9, "Doctor Strange teams up with a mysterious teenage girl who can travel across multiverses, to battle other-universe versions of himself which threaten to wipe out the multiverse. They seek help from the Scarlet Witch, Wong and others.", "2022-02-10", R.drawable.movie2),
        Movie("Iron Man 2", 6.9, "With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful mad man with ties to his father's legacy.", "2010-03-15", R.drawable.movie3),
        Movie("Avengers: Infinity War", 8.4, "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.", "2018-04-20", R.drawable.movie4),
        Movie("Avengers: Endgame", 8.4, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", "2019-05-25", R.drawable.movie5),
        Movie("The Avengers", 8.0, "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", "2012-06-30", R.drawable.movie6),
        Movie("The Dark Knight", 9.0, "When a menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman, James Gordon and Harvey Dent must work together to put an end to the madness.", "2008-07-10", R.drawable.movie7),
        Movie("Joker", 8.4, "Arthur Fleck, a party clown and a failed stand-up comedian, leads an impoverished life with his ailing mother. However, when society shuns him and brands him as a freak, he decides to embrace the life of chaos in Gotham City.", "2019-08-01", R.drawable.movie8),
        Movie("John Wick", 7.4, "John Wick is a former hitman grieving the loss of his true love. When his home is broken into, robbed, and his dog killed, he is forced to return to action to exact revenge.", "2014-09-11", R.drawable.movie9),
        Movie("Interstellar", 8.7, "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", "2014-10-05", R.drawable.movie10),
        Movie("Zack Snyder's Justice League", 7.9, "Determined to ensure that Superman's ultimate sacrifice wasn't in vain, Bruce Wayne recruits a team of metahumans to protect the world from an approaching threat of catastrophic proportions.", "2021-11-10", R.drawable.movie11),
        Movie("Venom", 6.6, "A failed reporter is bonded to an alien entity, one of many symbiotes who have invaded Earth. But the being takes a liking to Earth and decides to protect it.", "2018-12-01", R.drawable.movie12),
        Movie("Deadpool & Wolverine", 7.7, "Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.", "2024-01-02", R.drawable.movie13),
        Movie("Guardians of the Galaxy Vol. 2", 7.6, "The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lord's encounter with his father, the ambitious celestial being Ego.", "2017-02-15", R.drawable.movie14),
        Movie("Black Adam", 6.2, "Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods--and imprisoned just as quickly--Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.", "2022-03-21", R.drawable.movie15)
    )
}

