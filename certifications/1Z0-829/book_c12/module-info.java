
module zoo.animal.feeding {
    exports book_c12.zoo.animal.talks.content;
    exports book_c12.zoo.animal.talks.media;
    exports book_c12.zoo.animal.talks.schedule;

    requires book_c12.zoo.animal.feeding;
    requires book_c12.zoo.animal.care;
}
