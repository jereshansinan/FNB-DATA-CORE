import pandas as pd

df=pd.read_csv('./data/sales_data_sample.csv', encoding='unicode_escape')

print(df.head())

# Calculate total revenue - KPI
total_revenue = df['SALES'].sum()
print(f"Total Revenue: ${total_revenue:,.2f}")

# Pivot table for summary
summary_table = df.groupby(['PRODUCTLINE', 'TERRITORY'])['SALES'].sum().reset_index()

# Export Summary to a csv
summary_table.to_csv('./output/sales_summary.csv', index=False)

print("Summary successful! Check the output folder.")