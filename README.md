# Calculotron 3000

## 1. How to execute it

You need to have the *Java Development Kit* and *JavaFX* installed. Type this command (only once) :

``` bash
sudo apt install default-jdk openjfx
```

Then type the following command each time you want to execute the *Calculotron 3000* :

``` bash
./calculotron.sh
```

## 2. How to use it

You can process basics mathematical operations with two operands, e.g :

> 2+2

You can't have more than two operands !

> 4+6+2 wont works

The button `C` clears the result screen.

## 3. How to fix it

* The button `4` works but contains the text `#`. You need to replace it with `4`.
* Only the addition works. Please fix the subtraction, multiplication and division.

> You need to modify the Main.java file