![image-20190622231243816](/Users/daniowang/OneDrive/GitHub/Notes-on-Modern-Java/figures/stream_example.png)

Common Stream Operations:

`filter, map, reduce, find, match and sort` 

Pipelining: Many stream operations return a stream themselves, allowing operations to be chained to form a larger pipeline. This enables certain optimizations that we explain in the next chapter, such as laziness and short-circuiting. A pipeline of operations can be viewed as a database-like query on the data source.

`collect`—Converts a stream into another form. In this case you convert the stream into a list. It looks like a bit of magic; we’ll describe how collect works in more detail in chapter 6. At the moment, you can see collect as an operation that takes as an argument various recipes for accumulating the elements of a stream into a summary result.

