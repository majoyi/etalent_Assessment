Feature('Login etalent successfully')

const sUsername = 'edwin.ndlala@gmail.com'
const sPassowrd = '118526@Ed'
const sPassowrd2 = '118526@Ed11'

Scenario('Positive Test : login etalent with corrct Username and Passeword', ({ I }) => {
  I.amOnPage('https://etalente.co.za/')
  I.click('body > app-root > app-home > div > div.header-container > div > div:nth-child(1) > div.account-btns > a.mat-focus-indicator.mr-3.mat-flat-button.mat-button-base > span.mat-button-wrapper')
  I.wait(2)
  I.fillField('#mat-input-2', sUsername)
  I.fillField('#mat-input-3', sPassowrd)
  I.click('.pt-1')

  I.see('EDWIN NDLALA')
})
