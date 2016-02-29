# README #

This application is a very simple example of using the Spring framework to create an API for a blog.  All
examples that I created here I derived after reading the wonderful "Spring In Action" book by Craig Walls.
I would really recommend this book to anyone who wants to learn more about Spring.

This API is a very simple blog API.  I usually like to create quick blog applications when learning something
new - I find that it's small enough, yet contains enough complexity to cover a lot of use cases I may run up
against.  In this example, there would be three tables to run the app; Authors, Articles, and Tags.

* One Author writes many Articles
* One Article belongs to one Author
* Many Tags may belong to many Articles

With this relationship in mind, we can then create a simple RESTful API to pull and save author & article
information.

### How do I get set up? ###

This is a maven project, so all that's needed to build this is run maven with the target of package.  This will
execute all of the included unit tests.

Any questions or comments to this project can be submitted as tickets - and I do welcome feedback on this.