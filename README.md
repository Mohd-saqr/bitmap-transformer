# bitmap-transformer
for This Task :

### in test method i make all method return 0 for Fail and 1 for success
### in main class you can change the transformation method in function showResult and the output image in Resources/newImage.
```
examble

   Bitmap TEST = new Bitmap(DefaultInputPath, DefaultOutPutPath, "Rotate", 180);
      Bitmap TEST = new Bitmap(DefaultInputPath, DefaultOutPutPath, "Rotate", 45);
   Bitmap TEST = new Bitmap(DefaultInputPath, DefaultOutPutPath, "BlackAndWhite");
      Bitmap TEST = new Bitmap(DefaultInputPath, DefaultOutPutPath, "PixiLate", 10);
      
```
 ## note
````
the default input and out path  is  /mnt/c/Users/M.2070/MyWork/bitmap-transformer/app/src/main/resources/Name of method

````

``
when you run ./gradlew test new Image is shown in resourses filse 
``




### My METHOD
1- BlackAndWhite <br/>
2 - Rotate(rotation degree).  rotation degree is optional.<br/>
3 - PixiLate(percent ) . percent is optional


