import { Selector } from 'testcafe'


const sUsername = 'edwin.ndlala@gmail.com'
const sPassowrd = '118526@Ed'
const sPassowrd2 = '118526@Ed11'
const seector1 = Selector('span').withText('Log In')
const seector2 = Selector('span').withText('Login')
const seector3 = Selector('span').withText('FILTERS')
 
   
fixture('Positive Test : login etalent with corrct Username and Passeword')
.page('https://etalente.co.za/');


test('Login etalent with correct login detail', async t => {
    

    await t
    .wait(1500)
    .click(seector1)
    .click('#mat-input-2')
    .typeText('#mat-input-2',sUsername)
    .wait(1000)
    .typeText('#mat-input-3',sPassowrd)
    .click(seector2);
    


   // const nameInputElement = await seector3.with({ visibilityCheck: true })();
    await t
    .wait(1000)
    .expect(seector3.exists).ok();
  //  .expect(seector3.innerText).contains('FILTERS')

});



fixture('Negetive Test : login etalent with incorrct Username and Passeword')
.page('https://etalente.co.za/');

const errorLogin = Selector('p').withText('Invalid credentials provided')
test('Login etalent with incorrct login detail', async t => {
    

    await t
    .wait(1500)
    .click(seector1)
    .click('#mat-input-2')
    .typeText('#mat-input-2',sUsername)
    .wait(1000)
    .typeText('#mat-input-3',sPassowrd2)
    .click(seector2);
    


   // const nameInputElement = await seector3.with({ visibilityCheck: true })();
    await t
    .wait(1000)
    .expect(errorLogin.exists).ok();
  //  .expect(seector3.innerText).contains('FILTERS')

});

