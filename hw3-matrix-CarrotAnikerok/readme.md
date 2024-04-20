# ДЗ 3. Матрицы
## Дедлайн
**Мягкий дедлайн** - ~~30 сентября в 23-59~~ 02 октября в 12-00
**Жесткий дедлайн** - 07 октября в 23-59
## Как сдать
Реализуйте нужные методы в классе Matrix22. Для последней задачи создайте отдельный класс в отдельном файлике.
Запустите у себя на компьютере тесты. Для этого откройте консоль и выполните команду
```bash
./gradlew test
```

Если тесты прошли успешно - вы увидите надпись `BUILD SUCCESSFUL` , если же вы увидите надпись `BUILD FAILED`, то найдите в сообщении в терминале название теста и посмотрите этот тест в файле `src/test/groovy/MatrixSpec.groovy`

После этого отправьте свое решение в ветку **main**. Призовите меня (ivanetc) в комментариях, где, **пожалуйста**, **напишите** "Cдаю задачи 1, 2, 3 ... n".
Убедитесь, что тесты проходят локально.

## Матрицы 2x2
Создайте класс Matrix22, который хранит матрицы вещественных чисел 2 на 2. Например,
$$\begin{pmatrix}a&b\\c&d\end{pmatrix}$$. Вы можете выбрать любой способ хранения данной матрицы
в полях класса.

Не забудьте создать отдельный класс для тестирования всех реализованных возможностей `Matrix22`.

1. Создайте конструктор, в который передаются 4 числа: `new Matrix22(1, 2, 3, 4)`.
2. Создайте конструктор, в который передаётся двумерный массив:
   `new Matrix22(new int[][]\{\{1, 2}, {3,4}})`.
3. Создайте метод, вычисляющий след матрицы и дискриминант: $a+d$ и $ad-bc$.
4. Создайте метод (get-метод), возвращающий двумерный массив значений матрицы, аналогичный массиву, который передается в конструктор в задаче 2. Убедитесь, что изменения значений внутри возвращенного массива не влияют на значения внутри матрицы.
5. Создайте метод `String toString()`, который возвращает матрицу в виде строки.
6. Создайте метод `void print()`, который распечатывает матрицу, по возможности красиво — построчно и выровнено.
7. Создайте метод `add(Matrix22 b)`, который добавляет матрицу `b` и возвращает новую матрицу.
8. Создайте метод `mul(Matrix22 b)`, который умножает на матрицу `b` и возвращает новую матрицу.
9. Создайте метод `pow(int n)`, который возводит матрицу в степень $n$, т.е. умножает сам на себя $n$ раз.
10. Создайте функцию, которая возвращает $n$-ое число Фибоначчи, вычисляя $$\begin{pmatrix}1&1\\1&0\end{pmatrix}^n$$. Реализуйте эту функцию вне класса `Matrix22`.