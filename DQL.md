# DQL

Data query language is the set of statements We use to retrieve data from the tables

## SELECT

This is the basic structure of the SELECT statement:

```sql
SELECT
  column_a,
  column_b,
  column_c
FROM
  table_name
```

You can also use a filter and order the results:

```sql
SELECT
  column_a,
  column_b,
  column_c
FROM
  table_name
WHERE
  column_a = 'some value'
ORDER BY
  column_b DESC
```

> **Note:** Add the DISTINCT keyword on SELECT to fetch only unique rows

Here is a list of queries You would like to try:

- Simple query, all columns and lines
- Query only specific columns
- Query with a filter
- Query distinct lines
- Use arithmetic operators
- Give aliases to columns
- Sort by some columns (ORDER BY)
- Filter by relational operators (=, <, <=, <> and !=)
- Logic operators (AND, OR and NOT)
- Special operators (BETWEEN...AND, IN, LIKE and IS NULL)
- Like operator (% and \_)
- Concatenate texts (||)

## Pseudo Column ROWNUM

The ROWNUM pseudo column allows us to get the number of the line in the result. Take a look with this:

```sql
SELECT
	ROWNUM,
	table_name.*
FROM
  table_name;

-- you can use this column to limit the result, or even skip lines
SELECT
	ROWNUM,
	table_name.*
FROM
  table_name
WHERE
  ROWNUM < 5;
```

## TOP-N

Imagine You want to get the first N values given a sort filter. You can achieve that by using a sub query, to filter and sort the lines, and then use the ROWNUM column to get the TOP-N. Like this:

```sql
SELECT
  *
FROM
  (
    SELECT
      *
    FROM
      table_name
    ORDER BY
      column_a
  )
WHERE
  ROWNUM < 5
```

## NLS (National Language Support)

This are some parameters that control how the database will behave on the client and the server. Take a look in all the parameters with this:

```sql
SELECT
  *
FROM
  V$NLS_PARAMETERS
```

You can update the values from there with the ALTER SESSION statement:

```sql
ALTER SESSION
SET PARAMETER = 'VALUE';
```

# Exercise it!

- Recover the tasks
- Recover the tasks, but define some aliases for the columns
- Query results to get only the completed itens
- Get only the used priorities
- List the uncompleted tasks, but only the name and the percentage completed
- List the 3 next uncompleted tasks to expire 