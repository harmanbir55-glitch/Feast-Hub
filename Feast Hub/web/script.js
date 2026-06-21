const recipes = [
  { name: 'Chickpea Rice Bowl', ingredients: 'chickpeas, rice, onion, tomato', rating: 5 },
  { name: 'Vegetable Pasta', ingredients: 'pasta, peppers, spinach, cheese', rating: 4 }
];

const pantry = [
  { name: 'Rice', quantity: '2 kg', category: 'Grain' },
  { name: 'Chickpeas', quantity: '4 cans', category: 'Protein' },
  { name: 'Spinach', quantity: '1 bag', category: 'Vegetable' }
];

const supportLogs = [
  { issue: 'Recipe data backup needed', solution: 'Created backup copy and verified file recovery.' },
  { issue: 'User needed pantry guidance', solution: 'Provided training on adding and updating ingredients.' }
];

const recipeForm = document.querySelector('#recipeForm');
const pantryForm = document.querySelector('#pantryForm');
const supportForm = document.querySelector('#supportForm');
const backupBtn = document.querySelector('#backupBtn');

function render() {
  document.querySelector('#recipeCount').textContent = recipes.length;
  document.querySelector('#pantryCount').textContent = pantry.length;
  document.querySelector('#ticketCount').textContent = supportLogs.length;

  document.querySelector('#recipesList').innerHTML = recipes.map(recipe => `
    <div class="item">
      <strong>${recipe.name}</strong>
      <small>Ingredients: ${recipe.ingredients}</small><br>
      <small>Rating: ${'★'.repeat(recipe.rating)}${'☆'.repeat(5 - recipe.rating)}</small>
    </div>
  `).join('');

  document.querySelector('#pantryList').innerHTML = pantry.map(item => `
    <div class="item">
      <strong>${item.name}</strong>
      <small>Quantity: ${item.quantity}</small><br>
      <small>Category: ${item.category}</small>
    </div>
  `).join('');

  document.querySelector('#supportList').innerHTML = supportLogs.map(log => `
    <div class="item">
      <strong>Issue: ${log.issue}</strong>
      <small>Solution: ${log.solution}</small>
    </div>
  `).join('');
}

recipeForm.addEventListener('submit', event => {
  event.preventDefault();
  recipes.push({
    name: document.querySelector('#recipeName').value.trim(),
    ingredients: document.querySelector('#recipeIngredients').value.trim(),
    rating: Number(document.querySelector('#recipeRating').value)
  });
  recipeForm.reset();
  render();
});

pantryForm.addEventListener('submit', event => {
  event.preventDefault();
  pantry.push({
    name: document.querySelector('#pantryName').value.trim(),
    quantity: document.querySelector('#pantryQty').value.trim(),
    category: document.querySelector('#pantryCategory').value.trim()
  });
  pantryForm.reset();
  render();
});

supportForm.addEventListener('submit', event => {
  event.preventDefault();
  supportLogs.unshift({
    issue: document.querySelector('#issue').value.trim(),
    solution: document.querySelector('#solution').value.trim()
  });
  supportForm.reset();
  render();
});

backupBtn.addEventListener('click', () => {
  const timestamp = new Date().toLocaleString();
  supportLogs.unshift({
    issue: 'Manual web demo backup requested',
    solution: `Backup simulation completed successfully at ${timestamp}.`
  });
  render();
});

render();
