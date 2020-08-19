
//Selects top 10
SELECT TOP 10 * from CombinedTable;
//Selects any document that contains fish in the description
SELECT Document, Status, Description from CombinedTable where Description LIKE '%fish%';
//Selects any document proposed by Blood
SELECT * from CombinedTable where "Primary Introducer"='Blood';
//Selects Document with fish, before 2020
SELECT Document, Status, Description, "Update date"
from CombinedTable 
where Description LIKE '%fish%' AND ("Update date"<'2020');