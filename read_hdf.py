import sys

import pandas as pd


df = pd.read_hdf(sys.argv[1], "sample")

print(df.to_json(orient="records"))