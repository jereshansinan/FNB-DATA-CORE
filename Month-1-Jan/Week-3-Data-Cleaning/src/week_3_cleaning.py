import pandas as pd

df = pd.read_csv('./data/employees.csv')

# Remove exact duplicates
df = df.drop_duplicates()

# Handle missing values: Fill missing 'Salary' with the median
df['salary'] = df['salary'].fillna(df['salary'].median())

# Format strings: Make all Departments uppercase
df['department'] = df['department'].str.upper()

df.to_csv('./output/cleaned_employees_python.csv', index=False)

print("Data cleaning completed. Cleaned data saved to './output/cleaned_employees_python.csv'.")