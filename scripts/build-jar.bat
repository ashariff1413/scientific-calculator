@echo off
echo Compiling Java files...
.\bin\javac.exe -d build Calculator.java ComplexNumber.java ComplexParser.java ExpressionParser.java PolynomialSolver.java SystemSolver.java EquationSolver.java CalculusHelper.java

echo Creating JAR file...
cd build
..\bin\jar.exe cfm ScientificCalculator.jar ..\MANIFEST.MF *.class

echo Moving JAR to root...
move ScientificCalculator.jar ..

cd ..
echo Done! Run ScientificCalculator.jar to start the calculator.
pause
