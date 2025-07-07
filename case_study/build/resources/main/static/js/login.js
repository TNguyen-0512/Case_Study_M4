const loginForm = document.getElementById('loginForm');
const loginBtn = document.getElementById('loginBtn');
const loading = document.getElementById('loading');
const btnText = document.getElementById('btnText');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');
const usernameError = document.getElementById('usernameError');
const passwordError = document.getElementById('passwordError');

// Form validation
function validateForm() {
    let isValid = true;

    // Reset errors
    usernameError.style.display = 'none';
    passwordError.style.display = 'none';
    usernameInput.style.borderColor = '#e1e5e9';
    passwordInput.style.borderColor = '#e1e5e9';

    // Validate username
    if (!usernameInput.value.trim()) {
        usernameError.textContent = 'Vui lòng nhập tên đăng nhập hoặc email';
        usernameError.style.display = 'block';
        usernameInput.style.borderColor = '#ef4444';
        isValid = false;
    } else if (usernameInput.value.length < 3) {
        usernameError.textContent = 'Tên đăng nhập phải có ít nhất 3 ký tự';
        usernameError.style.display = 'block';
        usernameInput.style.borderColor = '#ef4444';
        isValid = false;
    }

    // Validate password
    if (!passwordInput.value) {
        passwordError.textContent = 'Vui lòng nhập mật khẩu';
        passwordError.style.display = 'block';
        passwordInput.style.borderColor = '#ef4444';
        isValid = false;
    } else if (passwordInput.value.length < 6) {
        passwordError.textContent = 'Mật khẩu phải có ít nhất 6 ký tự';
        passwordError.style.display = 'block';
        passwordInput.style.borderColor = '#ef4444';
        isValid = false;
    }

    return isValid;
}

// Real-time validation
usernameInput.addEventListener('input', function() {
    if (this.value.trim()) {
        usernameError.style.display = 'none';
        this.style.borderColor = '#10b981';
    }
});

passwordInput.addEventListener('input', function() {
    if (this.value.length >= 6) {
        passwordError.style.display = 'none';
        this.style.borderColor = '#10b981';
    }
});

// Form submission
loginForm.addEventListener('submit', function(e) {
    e.preventDefault();

    if (!validateForm()) {
        return;
    }

    // Show loading state
    loading.style.display = 'inline-block';
    btnText.textContent = 'Đang đăng nhập...';
    loginBtn.disabled = true;

    // Simulate API call
    setTimeout(() => {
        // In real implementation, you would submit to your server
        alert('Demo: Đăng nhập thành công!\nTrong thực tế, form sẽ được gửi đến server /login');

        // Reset button state
        loading.style.display = 'none';
        btnText.textContent = 'Đăng Nhập';
        loginBtn.disabled = false;
    }, 2000);
});

// Add enter key support
document.addEventListener('keypress', function(e) {
    if (e.key === 'Enter' && (usernameInput.value || passwordInput.value)) {
        loginForm.dispatchEvent(new Event('submit'));
    }
});

// Auto-focus first input
window.addEventListener('load', function() {
    usernameInput.focus();
});