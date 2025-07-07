document.addEventListener("DOMContentLoaded", function () {
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('animate');
                observer.unobserve(entry.target); // chỉ animate 1 lần
            }
        });
    }, observerOptions);

    document.querySelectorAll('.animate-on-scroll').forEach((el, index) => {
        el.style.transitionDelay = `${index * 0.1}s`; // stagger delay
        observer.observe(el);
    });
});
document.querySelector(".filter-form").addEventListener("submit", function (e) {
    e.preventDefault();
    const form = e.target;
    const params = new URLSearchParams(new FormData(form)).toString();

    fetch(`/product/filter?${params}`)
        .then(res => res.text())
        .then(html => {
            document.getElementById("product-container").innerHTML = html;
        });
});


