1, This is followed a tutorial from Youtube by thenewboston. 
2, The source code file: MyDBHandler.java is slightly different from the video. 
In the method databaseToString() in the while loop, adding one more sentence: c.moveToNext() is a must. Or else the while loop is not going to exit. 
3, in MainActivity.java I simply use AsyncTask to perform the work of retriveing data from the database which is quite reasonable for the reason: it may take a few miniutes if the database is large enough, in this case if we don't have the AsyncTask our UI thread is going to freeze.
