package com.adoyo.orbitallibrarry

import androidx.compose.ui.graphics.Color

data class Comic(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val color: Color = Color(0xFFEDEDED)
)


val comics = listOf(
    Comic(
        id = 1,
        image = "https://i.pinimg.com/564x/e0/f7/dc/e0f7dcc1f0a9657da69ab63c598624eb.jpg",
        title = "Frozen II",
        description = "Frozen II is a 2019 American 3D computer-animated musical fantasy film produced by Walt Disney Animation Studios. The 58th animated film produced by the studio, and the sequel to the 2013 film Frozen, it features the return of directors Chris Buck and Jennifer Lee, producer Peter Del Vecho, songwriters Kristen Anderson-Lopez and Robert Lopez, and composer Christophe Beck. Lee also returns as screenwriter, penning the screenplay from a story by her, Buck, Marc E. Smith, Anderson-Lopez, and Lopez,[2] while Byron Howard executive-produced the film. Veteran voice cast Idina Menzel, Kristen Bell, Jonathan Groff, Josh Gad, Santino Fontana, Ciarán Hinds, and Alan Tudyk return as their previous characters, and they are joined by newcomers Sterling K. Brown, Evan Rachel Wood, Alfred Molina, Martha Plimpton, Jason Ritter, Rachel Matthews, and Jeremy Sisto.",
        color = Color(0xFFffd7d7)
    ),
    Comic(
        id = 2,
        image = "https://i.pinimg.com/564x/35/fc/7f/35fc7f264a9dc2770318e0767ba96c38.jpg",
        title = "Toy Story 4",
        description = "Toy Story 4 is a 2019 American computer-animated comedy film produced by Pixar Animation Studios for Walt Disney Pictures. It is the fourth installment in Pixar's Toy Story series and the sequel to Toy Story 3 (2010). It was directed by Josh Cooley (in his feature directorial debut) from a screenplay by Andrew Stanton and Stephany Folsom; the three also conceived the story alongside John Lasseter, Rashida Jones, Will McCormack, Valerie LaPointe, and Martin Hynes.[2] The film stars the voices of Tom Hanks, Tim Allen, Annie Potts, Tony Hale, Keegan-Michael Key, Jordan Peele, Madeleine McGraw, Christina Hendricks, Keanu Reeves, Ally Maki, Jay Hernandez, Lori Alan, and Joan Cusack.",
        color = Color(0xFFffe9d6)
    ),
    Comic(
        id = 3,
        image = "https://i.pinimg.com/564x/c8/a9/c7/c8a9c7d9390b3274a02c77b720c267f1.jpg",
        title = "The Lion King",
        description = "The Lion King is a 2019 American musical drama film directed and produced by Jon Favreau, written by Jeff Nathanson, and produced by Walt Disney Pictures. It is a photorealistic computer-animated remake of Disney's traditionally animated 1994 film of the same name. The film stars the voices of Donald Glover, Seth Rogen, Chiwetel Ejiofor, Alfre Woodard, Billy Eichner, John Kani, John Oliver, Florence Kasumba, Eric Andre, Keegan-Michael Key, JD McCrary, Shahadi Wright Joseph, and Beyoncé Knowles-Carter, as well as James Earl Jones reprising his role from the original film.",
        color = Color(0xFFfffbd0)
    ),
    Comic(
        id = 4,
        image = "https://i.pinimg.com/564x/da/24/9b/da249b86ee49592e2d4f758e56aedc18.jpg",
        title = "Aladdin",
        description = "Aladdin is a 2019 American musical fantasy film produced by Walt Disney Pictures. Directed by Guy Ritchie, from a script he co-wrote with John August, it is a live-action adaptation of Disney's 1992 animated film of the same name, which itself is based on the eponymous tale from One Thousand and One Nights.[6][7] The film stars Will Smith, Mena Massoud, Naomi Scott, Marwan Kenzari, Navid Negahban, Nasim Pedrad, and Billy Magnussen. In the film, street urchin Aladdin finds a magic lamp and must use it to win over Princess Jasmine and defeat the evil Jafar."
    ),
    Comic(
        id = 5,
        image = "https://i.pinimg.com/564x/59/1b/14/591b14548e85e54bfeec704356c66131.jpg",
        title = "Bambi",
        description = "Bambi is a 1942 American animated drama film directed by David Hand (supervising a team of sequence directors), produced by Walt Disney and based on the 1923 book Bambi, a Life in the Woods by Austrian author and hunter Felix Salten. The film was released by RKO Radio Pictures on August 13, 1942, and is the fifth Disney animated feature film.",
        color = Color(0xFFd0fff8)
    ),
)