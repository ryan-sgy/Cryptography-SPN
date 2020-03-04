# SPN - 6331 Project 1
## Check your java version
`$ java -version`    
My java version is 1.8.0, and you need install higher version than mine.   
## The structure of my input and output file
After you download my project, you will find my input_spn.txt and output_spn.txt in the /SPN/src/resources.  
#### My input file contains the following information:  
**1. m**  
It is the lenght of the input plain text in bits.  
If you want to revise it, it must be a multiple of 32.  
**2. Message(x)**  
You can revise the input. But keep the length of it is m bits.   
**3. Key**   
To make read file more convenient, I divide all Keys into 9 lines and read one line at each time. The length of each line is 32 bits.   
You could revise 0 or 1 in each line on your own will, but you need keep KEY in the format of 9 lines and each line is 32 bits. BTW, **DONOT** delete any of `,`.  
**4. S-box(function f)**  
You could change the S-box function f on you will. But keep in the following format:  
`Integer1,Integer2`  
(For example, `0,255`)  j 
Integer1 and Integer 2 should range from 0 to 255. And each number from 0 to 255 must only appear one time in the list of Integer1 or Integer2.  
After you revise the function, the total lines of S-box function should be 256.  
**5. Permutation**  
Permutation function σ is in the format of `Integer1,Integer2` in 32 lines.  
**6. a**   
The value of `a` indicates decrypt or encrypt. You can choose 1 or 0. If you input the other numbers, the output file will write `You input an invalid 'a'!`.  
#### My output file contains the following information:
1. It will show whether you are doing encrypting or decrypting now.    
2. It will show the key(K) length of 36bytes.  
3. It will show the S-box function f in the format of f(Integer1) = Integer2.  
4. It will show the permutation function σ in the format of σ(Integer1) = Integer2.  
5. It will show an encrypted or decrypted output of length m bits.  
6. It will show the length of output in bits. E_k(x) if a = 0, and D_k(x) if a = 1. 
7. It will show an Integer representing a‘s anti.  
## How to run my project
After revise my input_spn.txt, you can run my code on a shell(Linux) or a terminal(Mac OS).   
Step 1: go to the directory.   
`cd /../SPN`   
Step 2: run SPN.jar.   
`java -jar SPN.jar`      
Step 3: open the output_spn.txt to check the output.  
`vi src/resources/output_spn.txt`    
## Testing
If you input a message x1 length of m bits and do encrypt first, you will get an encrypt output x2 in the output_spn.txt. Then you can replace the `Message(x)` in the input_spn.txt with x2 and change a to 1.   
Run S-box.jar again.  
You will do decrypt and get x1 as the decrypt output.
