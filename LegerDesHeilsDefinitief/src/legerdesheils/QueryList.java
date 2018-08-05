/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

/**
 *
 * @author AlexAnders
 * Class die lijsten van titels en queries bevat
 */
public class QueryList {
    
    private String[] titel = {
            "Medewerkers die uit dienst zijn in CleverNew", 
            "Medewerkers die uit dienst zijn in Profit",
            "Medewerkers onbekend in Profit",
            "Medewerkers onbekend in Clever",
            "RDS namen van CleverNew staan niet in AD",
            "RDS namen in Profit staan niet in AD ",
            "RDS namen in Clever staan leeg", 
            "RDS namen staan in Profit maar niet in Clever",
            "RDS namen staan in Clever maar niet in Profit",
            "Medewerkers die actief staan in Clever maar niet in Profit",
            "impact1",
            "impact2",
            "impact3",
            "impact4",
            "inlezen"}; 
    
    
    //Lijst of queries. Niet formatteren!
    private String[] query = {
"SELECT P.ID, PC.Code\n" +
"FROM Medewerker W\n" +
"JOIN Persoon P\n" +
"ON W.PersoonID = P.ID\n" +
"JOIN PersoonCodes PC\n" +
"ON P.ID = PC.PersoonID\n" +
"JOIN [AD-Export] A\n" +
"ON PC.Code = A.Username_Pre2000\n" +
"WHERE PC.Code != 'Andere Code'\n" +
"AND A.Disabled = 0\n" +
"AND PC.CodesoortenID != 981",
        
"SELECT EmployeeUsername\n" +
"FROM [AfasProfit-Export] AFAS\n" +
"JOIN [AD-Export] AD\n" +
"ON AFAS.EmployeeUsername = AD.Username_Pre2000\n" +
"WHERE AD.Disabled = 0\n" +
"AND AFAS.ContractEndDate > ContractStartDate",

"SELECT Username_Pre2000\n" +
"FROM [AD-Export]\n" +
"WHERE Username_Pre2000 NOT IN\n" +
"(SELECT EmployeeUsername\n" +
"FROM [AfasProfit-Export]\n" +
"WHERE Username_Pre2000 = EmployeeUsername)",

"SELECT Username_Pre2000\n" +
"FROM [AD-Export]\n" +
"WHERE Username_Pre2000 NOT IN\n" +
"(SELECT PC.Code\n" +
"FROM Medewerker M\n" +
"JOIN Persoon P\n" +
"ON P.ID = M.PersoonID\n" +
"JOIN PersoonCodes PC\n" +
"ON PC.PersoonID = P.ID)",

"SELECT P.ID, AFAS.EmployeeUsername\n" +
"FROM [AfasProfit-Export] AFAS\n" +
"JOIN PersoonCodes PC\n" +
"ON AFAS.EmployeeUsername = PC.Code\n" +
"JOIN Persoon P\n" +
"ON PC.PersoonID = P.ID\n" +
"WHERE AFAS.ContractEndDate > AFAS.ContractStartDate\n" +
"AND PC.CodesoortenID = 981",

"SELECT P.ID, PC.Code\n" +
"FROM Medewerker M\n" +
"JOIN Persoon P\n" +
"ON P.ID = M.PersoonID\n" +
"JOIN PersoonCodes PC\n" +
"ON P.ID = PC.PersoonID\n" +
"LEFT JOIN [AfasProfit-Export] AFAS\n" +
"ON AFAS.EmployeeUsername = PC.Code\n" +
"WHERE AFAS.EmployeeUsername IS NULL\n" +
"AND PC.Code != 'Andere Code'",

"SELECT a.EmployeeUsername baAccount\n" +
"FROM [AfasProfit-Export] a \n" +
"WHERE a.EmployeeUsername NOT IN  \n" +
"(SELECT pc.Code \n" +
"FROM Medewerker w \n" +
"JOIN Persoon p \n" +
"ON w.PersoonID = p.ID\n" +
"JOIN PersoonCodes pc \n" +
"ON p.ID = pc.PersoonID)",

"SELECT P.ID\n" +
"FROM Medewerker M\n" +
"JOIN Persoon P\n" +
"ON M.PersoonID = P.ID\n" +
"JOIN PersoonCodes PC\n" +
"ON P.ID = PC.PersoonID\n" +
"WHERE PC.Code = 'Andere Code'\n" +
"OR PC.Code IS NULL",

"SELECT EmployeeUsername baAccount \n" +
"FROM [AfasProfit-Export] \n" +
"WHERE [EmployeeUsername] NOT IN \n" +
"(\n" +
"SELECT [Username_Pre2000] \n" +
"FROM [AD-Export] \n" +
"WHERE [Username_Pre2000] = [EmployeeUsername])\n" +
" ",

"SELECT p.[ID] AS [personID], pc.[Code]\n " +
"FROM [Medewerker] AS m\n " +
"JOIN [Werkzaam] w ON w.[MedewerkerID] = m.[ID]\n " +
"JOIN [Persoon] AS p ON p.[ID] = m.[PersoonID]\n " +
"JOIN [PersoonCodes] AS pc ON pc.[PersoonID] = p.[ID]\n " +
"LEFT OUTER JOIN [AfasProfit-Export] AS a ON a.[EmployeeUsername] = pc.[Code]\n " +
"WHERE a.[EmployeeUsername] IS NULL\n " +
"AND pc.[Code] != 'Andere Code'",


"SELECT oe.OrganisatieID\n" +
"FROM PersoonCodes pc \n" +
"JOIN Medewerker m \n" +
"ON pc.PersoonID = m.PersoonID\n" +
"JOIN Werkzaam w \n" +
"ON m.ID = w.MedewerkerID\n" +
"JOIN OrganisatieEenheid oe\n" +
"ON w.OrganisatieEenheidID = oe.OrganisatieID\n" +
"WHERE pc.Code = 'dad001hhs' AND pc.CodesoortenID = 981",

"SELECT a.ActiviteitSoortID, COUNT(a.ActiviteitSoortID) AS aantal\n" +
"FROM PersoonCodes pc\n" +
"JOIN TeamLid tl\n" +
"ON pc.PersoonID = tl.PersoonID\n" +
"JOIN AuditBlackBox.dbo.Team t\n" +
"ON t.ID = tl.TeamID\n" +
"JOIN Activiteit a\n" +
"ON a.TeamID = t.ID\n" +
"WHERE pc.CodesoortenID = 981\n" +
"AND PC.Code = 'zst002hhs'\n" +
"GROUP BY a.ActiviteitSoortID",

"SELECT a.Status, COUNT(a.Status) AS aantal\n" +
"FROM PersoonCodes pc\n" +
"JOIN TeamLid tl\n" +
"ON pc.PersoonID = tl.PersoonID\n" +
"JOIN Team t\n" +
" ON t.ID = tl.TeamID\n" +
"JOIN Activiteit a\n" +
"ON a.TeamID = t.ID\n" +
"WHERE pc.CodesoortenID = 981\n" +
"AND pc.Code = 'dad001hhs'\n" +
"GROUP BY a.Status",

"SELECT e.Naam, rol.Naam, r.Creëren, \n" +
"r.Lezen, r.Wijzigen, r.Verwijderen\n" +
"FROM PersoonCodes pc\n" +
"JOIN PersoonTotRol pr\n" +
"ON pc.PersoonID = pr.PersoonID\n" +
"JOIN Rol rol\n" +
"ON rol.ID = pr.RolID - 1926\n" +
"JOIN Recht r\n" +
"ON r.RolID = rol.ID + 1926\n" +
"JOIN Entiteit e\n" +
"ON e.ID = r.EntiteitID\n" +
"WHERE pc.CodesoortenID = 981\n" +
"AND pc.Code = 'dad001hhs'\n" +
"AND (r.Creëren = 1\n" +
"OR r.Lezen = 1\n" +
"OR r.Wijzigen = 1\n" +
"OR r.Verwijderen = 1)",

"SELECT TOP 100 * \n" + 
"FROM [AfasProfit-Export], [AD-Export], Medewerker \n"

};

    public String getQueryTitle(int num){
        return(titel[num]);
        
      }
    
     public String getQueryText(int num){
        return(query[num]);
     }
    
}
