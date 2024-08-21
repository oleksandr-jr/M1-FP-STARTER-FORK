
## Run the program

### Commands:

```
-e Encrypt
-d Decrypt
-bf Brute force
```

### Arguments:
```
-k Key
-f File path
```

### Example:
```
-e -k 1 -f "/path/to/file.txt"  - Encrypt file with key 1
-d -k 5 -f "/path/to/file [ENCRYPTED].txt" - Decrypt file with key 5
-bf -f "/path/to/file [ENCRYPTED].txt" - Brute force decrypt file
```

### Argument could be in any order
```
-e -f "/path/to/file.txt" -k 1
```