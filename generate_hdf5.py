import pandas as pd


df = pd.DataFrame({
    "col1": [1, 2, 3, 4, 5, 6],
    "col2": [6, 7, 8, 9, 10, 11]
})

df.to_hdf("testout.hdf5", "sample")
