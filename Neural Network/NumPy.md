# NumPy

## numpy.T

- Usage

  - 转置矩阵（目前对于一维行向量没有作用）。

- Implementation

  ```python
  import numpy as np
  vect1 = np.array([[1],[2],[3]])
  vect2 = np.array([1,2,3])
  print("vect1")
  print(vect1)
  print("")
  print("vect1.T")
  print(vect1.T)
  print("")
  print("vect2")
  print(vect2)
  print("")
  print("vect2.T")
  print(vect2.T)
  print("")
  ```

  ```shell
  # output
  vect1
  [[1]
   [2]
   [3]]
  vect1.T
  [[1 2 3]]
  vect2
  [1 2 3]
  vect2.T
  [1 2 3]
  ```

## numpy.dot()

- Usage

  - 向量点积，不需要考虑行列对应。

  - 矩阵求积，需要考虑行列数量对应。

    <!--比如矩阵[2*3]*[3*2] = [2*2]-->

- Implementation

  ```python
  import numpy as np
  vect2 = np.array([1,2,3])
  a1 = np.array([
      [1,2,3],
      [4,5,6]
  ])
  a2 = np.array([
      [7,8,9],
      [10,11,12]
  ])
  
  print("vect2 * vect2")
  print(vect2.dot(vect2))
  print("")
  
  print("vect2 * vect2.T")
  print(vect2.dot(vect2))
  print("")
  
  print("a1")
  print(a1)
  print("")
  
  print("a2")
  print(a2)
  print("")
  
  print("a1.T * a2")
  print(a1.T.dot(a2))
  print("")
  
  print("a1 * a2.T")
  print(a1.dot(a2.T))
  print("")
  
  # Error:shapes (2,3) and (2,3) not aligned: 3 (dim 1) != 2 (dim 0)
  # print("a1 * a2")
  # print(a1.dot(a2))
  ```

  ```shell
  # output
  vect2 * vect2
  14
  
  vect2 * vect2.T
  14
  
  a1
  [[1 2 3]
   [4 5 6]]
   
  a2
  [[ 7  8  9]
   [10 11 12]]
   
  a1.T * a2
  [[47 52 57]
   [64 71 78]
   [81 90 99]]
   
  a1 * a2.T
  [[ 50  68]
   [122 167]]
  ```

## s:s+1

- Usage

  - 循环中的向量或者矩阵索引

- Implementation

  ```python
  s = 0
  print("s:" + str(s))
  s:s+1
  print("s:s+1:" + str(s))
  ```

  ```shell
  # output
  s:0
  s:s+1:0
  ```

## Boolean

- Usage
  - True与1等值，False与0等值