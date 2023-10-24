Feature('etalent Failed login')

const sUsernamef = 'edwin.ndlala@gmail.com'
const sPassowrdf = '118526@Ed1'
/////const sPassowrd2 = '118526@Ed11'

Scenario('Login etalent with incorrct login detail', ({ I }) => {
  I.amOnPage('https://etalente.co.za/')
  I.click('body > app-root > app-home > div > div.header-container > div > div:nth-child(1) > div.account-btns > a.mat-focus-indicator.mr-3.mat-flat-button.mat-button-base > span.mat-button-wrapper')
  I.wait(2)
  I.fillField('#mat-input-2', sUsernamef)
  I.fillField('#mat-input-3', sPassowrdf)
  I.click('.pt-1')

  I.see('INVALID LOGIN DETAILS')
})
