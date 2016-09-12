# ASCL-Chmod

CHMOD is a command in the UNIX computer system. It is the command used for giving users
permissions to access and change files and directories. There are 3 classes of users. 
They are the owner, the group and others. The permissions given are: read(r), write(w) and execute(x).

The argument of the CHMOD command is a 3-character octal number (ex. 526). 
When each digit of that number is converted to binary, the binary digits are paired to represent read, 
write and execute in that order. 526 would convert to 101 010 110.

The first binary conversion gives the user permissions. The second gives the group permissions. 
The third gives the others permissions. So here, the owner has read and execute permissions and 
that is represented by r-x. The group has only write permission given by -w-. 
The others class has read and write permissions as given by rw-.

Putting all of the above together CHMOD 526 = 101 010 110 = r-x -w- rw-

Further, a fourth octal digit can be added on the left. This digit gives special permissions such as 
the ability to change passwords, rename files and delete files. The permissions only apply if the class
already has the execute permission. A special permission of 0 indicates no special permissions are granted. 
A special permission of 1 applies only to the owner. A special permission of 2 applies only to the group class.
A special permission of 4 applies only to the others class. When the special permissions are applied to either 
the owner or group classes, the x is changed to an s. When applied to the others class, the x is changed to a t.
